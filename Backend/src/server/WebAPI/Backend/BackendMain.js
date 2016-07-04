var express = require('express');
var router = express.Router();
var fs = require('fs')

var bodyParser = require("body-parser");
var _ = require('lodash');

var init = require('../../lib/init.js');

var BackendMain ={

    init: function(app){

        var self = this;
        
        router.use("/test", require("./Controllers/Test/TestController").init(app));
        router.use("/signup", require("./Controllers/Signup/SignupGeneralController").init(app));
        router.use("/signin", require("./Controllers/Signin/SigninGeneralController").init(app));
        router.use("/proflie/update", require("./Controllers/Profile/UpdateProflieController").init(app));

        return router;

    }

}

module["exports"] = BackendMain;