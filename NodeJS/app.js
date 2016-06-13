var express =  require("express");
var app = express();
var port = 8080;
app.set('port', port);

app.get("/", function(req, res){
   res.send("This is the main page"); 
});

app.get("/defined", function(req, res){
   res.send("This is a static defined page"); 
});

app.get("/test/:anything",function(req, res){
    var word = req.params.anything;
    res.send("This is a dynamic page that depends on the word after test. "
    + "This word is "+ word ); 
});









app.get("*", function(req, res){
    res.send("This shows on all pages with not defined urls"); 
}); 

app.listen(app.get('port'), function(){
   console.log("Now listening to server"); 
});