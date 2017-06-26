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
        rewindRequests.push("/hits/backwards");
        return $http.get("/hits/forwards")
        .then(function(response) {
            $log.info('fowards hit');
            this.requestedData = "";
            this.requestedData.concat(response.data);
        });
    }

    function _driveBackwards() {
        $log.info('backwards function entered');
        rewindRequests.push("/hits/forwards");
        return $http.get("/hits/backwards")
        .then(function(response) {
            $log.info('backwards hit');
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveRight() {
        $log.info('right function entered');
        rewindRequests.push("/hits/left");
        return $http.get("/hits/right")
        .then(function(response) {
            $log.info('right hit');
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveLeft() {
        $log.info('left function entered');
        rewindRequests.push("/hits/right");
        return $http.get("/hits/left")
        .then(function(response) {
            $log.info('left hit');
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }



    function _rewind() {
        $log.info('left function entered');
        return $http.get("/hits/rewind")
            .then(function(response) {
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
                    _driveForwards();
                }
                while (rewindRequests.length > 0) rewindRequests.pop();
                this.requestedData = "";
                this.requestedData = response.data;
            });
    }
}