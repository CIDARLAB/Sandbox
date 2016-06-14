var router = require('express').Router();

router.get("/", function(req, res){
   res.send("This is the main page"); 
});

router.get("/defined", function(req, res){
   res.send("This is a static defined page"); 
});

router.get("/test/:anything",function(req, res){
    var word = req.params.anything;
    res.send("This is a dynamic page that depends on the word after test. "
    + "This word is "+ word ); 
});

router.get("*", function(req, res){
    res.send("Testing priorty"); 
});

module.exports = router;