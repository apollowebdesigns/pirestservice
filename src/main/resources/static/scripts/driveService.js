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

    localStorage.rewindRequests = [];

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

    function _driveForwards(input) {
        $log.info('fowards function entered');
        return $http.get("/hits/forwards")
        .then(function(response) {
            $log.info('fowards hit');
            if (input === undefined || input.length === 0) {
                localStorage.rewindRequests.push("/hits/backwards");
            }
            this.requestedData = "";
            this.requestedData.concat(response.data);
        });
    }

    function _driveBackwards(input) {
        $log.info('backwards function entered');
        return $http.get("/hits/backwards")
        .then(function(response) {
            $log.info('backwards hit');
            if (input === undefined || input.length === 0) {
                localStorage.rewindRequests.push("/hits/forwards");
            }
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveRight(input) {
        $log.info('right function entered');
        return $http.get("/hits/right")
        .then(function(response) {
            $log.info('right hit');
            if (input === undefined || input.length === 0) {
                localStorage.rewindRequests.push("/hits/left");
            }
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveLeft(input) {
        $log.info('left function entered');
        return $http.get("/hits/left")
        .then(function(response) {
            $log.info('left hit');
            if (input === undefined || input.length === 0) {
                localStorage.rewindRequests.push("/hits/right");
            }
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
                for (var i = 0; i < localStorage.rewindRequests.length; i++) {
                    tempRequests.push(localStorage.rewindRequests[i]);
                }
                $log.info("temp requests are");
                $log.debug(tempRequests);
                for (var i = tempRequests.length - 1; i >= 0; i--) {
                    //getRewind(tempRequests[i]);
                    //_driveForwards();
                    getRewind(tempRequests[i])
                }

                //cleaning out localstorage
                while (localStorage.rewindRequests.length > 0) localStorage.rewindRequests.pop();
                localStorage.rewindRequests.length = 0;
                localStorage.rewindRequests = [];
                localStorage.removeItem("rewindRequests");
            });
    }
}