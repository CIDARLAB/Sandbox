var express =  require("express");
var server = express();
var port = 8080;
server.set('port', port);

var mainRoutes = require('./routes/main.js');
server.use(mainRoutes);

server.get("*", function(req, res){
    res.send("This shows on all pages with not defined urls"); 
}); 

server.listen(server.get('port'), function(){
   console.log("Now listening to server"); 
});