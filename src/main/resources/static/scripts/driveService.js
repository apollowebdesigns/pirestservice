angular
    .module('app')
    .service('driveService', driveService);

driveService.$inject = ['$http', 'rewindFactory'];

function driveService ($http, rewindFactory) {
    this.driveData = _driveData;
    this.driveForwards = _driveForwards;
    this.driveBackwards = _driveBackwards;
    this.driveRight = _driveRight;
    this.driveLeft = _driveLeft;
    this.rewind = _rewind;

    this.requestedData = "";

    localStorage.rewindRequests = [];

    var uniqueIP = "192.168.1.69";
    var uniqueIPparents = "192.168.1.74";
    var redSdCardIp = "192.168.1.73";

    function _driveData() {
        console.info('driving function entered function entered');
        return $http.get("/hits/motor")
        .then(function(response) {
            console.info('data received');
            this.requestedData = "";
            this.requestedData.concat(response.data);
        });
    }

    function _driveForwards() {
        console.info('fowards function entered');
        return $http.get("/hits/forwards")
        .then(function(response) {
            console.info('fowards hit');
            rewindFactory.rewindRequests.push("/hits/backwards");
            this.requestedData = "";
            this.requestedData.concat(response.data);
        });
    }

    function _driveBackwards() {
        console.info('backwards function entered');
        return $http.get("/hits/backwards")
        .then(function(response) {
            console.info('backwards hit');
            rewindFactory.rewindRequests.push("/hits/forwards");
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveRight() {
        console.info('right function entered');
        return $http.get("/hits/right")
        .then(function(response) {
            console.info('right hit');
            rewindFactory.rewindRequests.push("/hits/left");
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveLeft() {
        console.info('left function entered');
        return $http.get("/hits/left")
        .then(function(response) {
            console.info('left hit');
            rewindFactory.rewindRequests.push("/hits/right");
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function getRewind(input) {
        switch(input) {
            case "/hits/backwards":
                return _driveBackwards(input);
                break;
            case "/hits/forwards":
                return _driveForwards(input);
                break;
            case "/hits/left":
                return _driveLeft(input);
                break;
            case "/hits/right":
                return _driveRight(input);
                break;
        }
    }

    function _rewind() {
        console.info('left function entered');
        return $http.get("/hits/rewind")
            .then(function() {
                console.info('lets rewind');
                var tempRequests = rewindFactory.rewindRequests;
                console.info("temp requests are");
                $log.debug(tempRequests);
                for (var i = tempRequests.length - 1; i >= 0; i--) {
                    getRewind(tempRequests[i])
                }
                while (rewindFactory.rewindRequests.length > 0) {
                    rewindFactory.rewindRequests.pop();
                }
            });
    }
}