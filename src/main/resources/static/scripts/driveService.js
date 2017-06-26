angular
    .module('app')
    .service('driveService', driveService);

driveService.$inject = ['$http', '$log'];

function driveService ($http, $log) { 
    this.driveData = _driveData;
    this.driveForwards = _driveForwards;
    this.driveBackwards = _driveBackwards;
    this.driveRight = _driveRight;
    this.driveLeft = _driveLeft;
    this.rewind = _rewind;

    this.requestedData = "";

    var rewindRequests = [];

    var uniqueIP = "192.168.1.69";
    var uniqueIPparents = "192.168.1.74";
    var redSdCardIp = "192.168.1.73";

    function _driveData() {
        $log.info('driving function entered function entered');
        return $http.get("/hits/motor")
        .then(function(response) {
            $log.info('data received');
            this.requestedData = "";
            this.requestedData.concat(response.data);
        });
    }

    function _driveForwards() {
        $log.info('fowards function entered');
        return $http.get("/hits/forwards")
        .then(function(response) {
            $log.info('fowards hit');
            rewindRequests.push("/hits/backwards");
            this.requestedData = "";
            this.requestedData.concat(response.data);
        });
    }

    function _driveBackwards() {
        $log.info('backwards function entered');
        return $http.get("/hits/backwards")
        .then(function(response) {
            $log.info('backwards hit');
            rewindRequests.push("/hits/forwards");
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveRight() {
        $log.info('right function entered');
        return $http.get("/hits/right")
        .then(function(response) {
            $log.info('right hit');
            rewindRequests.push("/hits/left");
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveLeft() {
        $log.info('left function entered');
        return $http.get("/hits/left")
        .then(function(response) {
            $log.info('left hit');
            rewindRequests.push("/hits/right");
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }



    function _rewind() {
        $log.info('left function entered');
        return $http.get("/hits/rewind")
            .then(function(response) {
                //create local rewind object

                var requestTable = {
                    "/hits/backwards" : _driveBackwards(),
                    "/hits/forwards" : _driveForwards(),
                    "/hits/left" : _driveLeft(),
                    "/hits/right" : _driveRight()
                };

                $log.info('lets rewind');
                var tempRequests = [];
                for (var request in rewindRequests) {
                    tempRequests.push(rewindRequests[request]);
                }
                function getRewind(i) {
                    return $http.get(tempRequests[i]).then(function (response) {
                        $log.debug(response);
                    });
                }
                for (var i = tempRequests.length - 1; i >= 0; i--) {
                    //getRewind(tempRequests[i]);
                    //_driveForwards();
                    switch(tempRequests[i]) {
                        case "/hits/backwards":
                            _driveBackwards();
                            break;
                        case "/hits/forwards":
                            _driveForwards();
                            break;
                        case "/hits/left":
                            _driveLeft();
                            break;
                        case "/hits/right":
                            _driveRight();
                            break;
                    }
                }
                while (rewindRequests.length > 0) rewindRequests.pop();
                rewindRequests.length = 0;
                rewindRequests = [];
            });
    }
}