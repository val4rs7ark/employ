var port = 8888;

var names = [];

var clients = [];

var contents = [];

var io = require('socket.io').listen(port);  // 8888 포트로 소켓을 엽니다

console.log('server running at '+port+' port');

io.sockets.on('connection', function (socket) { // connection이 발생할 때 핸들러를 실행합니다.

  io.sockets.emit('conn', 'connected');

  socket.on('message', function(message){
    contents.push(message);
    console.log('message : contents --> '+contents);
    io.sockets.emit('message', message);  //client에 message 라는 키로 값을 전송합니다.

  });
  socket.on('modal', function(data){
    console.log('modal : contents --> '+data);
    io.sockets.emit('modal', data);  //client에 data 라는 키로 값을 전송합니다.

  });
  socket.on('talkLogin', function(name){
    //접속한 유저들 정보(유저 name, 유저 소켓 id)
    var clientInfo = new Object();
    clientInfo.name = name;
    clientInfo.id = socket.id;
    clients.push(clientInfo);
    //접속한 유저의 name을 배열에 저장
    if(names.length > 1 ){
      console.log('checkNames --> '+name);
      var check = 0;
      for(var i=0, item; item=names[i]; i++){
        if(item == name) check++;
      }
      if(check == 0 ) names.push(name);
    }else {
      names.push(name);
    }
    //접속하기 이전 메세지들 접속한 유저에게만 보여주기
    io.to(socket.id).emit('firstMsg', contents);

    console.log('emit : names --> '+names);
    io.sockets.emit('talkList', names);  //client에 name 라는 키로 값을 전송합니다.

  });
  //나간 유저를 name 배열에서 빼고 다시 emit
  socket.on('disconnect', function() {
    for (var i=0; i < clients.length; i++) {
        var client = clients[i];
        if (client.id == socket.id) {
            clients.splice(i, 1);
            let idx = names.indexOf(client.name);
            if (idx > -1) names.splice(idx, 1);
            break;
        }
    }
    io.sockets.emit('talkList', names);
    console.log('user disconnected');
  });

});
