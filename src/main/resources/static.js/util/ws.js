var stompClient = null

export function connect() {
    const socket = new SockJS('/gs-guide-websocket')
    stompClient = Stomp.over(socket)
    stompClient.connect({}, frame => {
        console.log('Connected: ' + frame)
        stompClient.subscribe('/topic/chat', message => {
            // showGreeting(JSON.parse(greeting.body).content)
        })
    })
}

export function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect()
    }
    setConnected(false)
    console.log("Disconnected")
}

export function sendMessage(message) {
    stompClient.send("/chat/sendMessage", {}, JSON.stringify(message))
}