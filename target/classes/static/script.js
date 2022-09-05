var stompClient = null;

function connect() {
    disconnect();
    loadUuid();
    var socket = new SockJS('/chat-messaging');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("connected: " + frame);
        stompClient.subscribe('/chat/messages', function (response) {
            var data = JSON.parse(response.body);
            uuid = getUuid();
            if (uuid === data.fromUUID) {
                draw("right", data);
            } else {
                draw("left", data);
            }

        });
    });
    logged();
}

function draw(side, data) {
    console.log("drawing...");
    var $message;
    $message = $($('.message_template').clone().html());
    $message.addClass(side).find('.text').html(data.message);
    $message.find('.message_top').html(side);
    $message.find('.date').html(data.date);
    $message.find('.username').html(data.fromName);
    $message.find('.avatar').html(data.letterAvatar);
    $('.messages').append($message);
    return setTimeout(function () {
        return $message.addClass('appeared');
    }, 0);

}
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
        localStorage.clear();
    }
}

function sendMessage() {
    stompClient.send("/app/message", {}, JSON.stringify({'message': $("#message_input_value").val(), 'from': getUuid()}));
    $("#message_input_value").val('');

}

function loadUuid() {

    $.ajax({
        type: "POST",
        url: "/register",
        data: encodeURIComponent($("#message_input_value").val()),
        success: function (data, textStatus, jQxhr) {
            localStorage.setItem("uuid", data);
            localStorage.setItem("name", name);
        },
        dataType: "text"
    });
}

function getUuid() {
    return localStorage.getItem("uuid");
}

function start() {
    disconnect();
    $('#message_input_value').attr('placeholder', 'Tell your name to join us');
    $('.send_message').find('.icon').html("Join us");
    $(".send_message").attr("onclick","connect()");
}

function logged(){
    $('#message_input_value').attr('placeholder', 'Message ...');
    $('.send_message').find('.icon').html("Send");
    $(".send_message").attr("onclick","sendMessage()");
    $("#message_input_value").val('');
}
