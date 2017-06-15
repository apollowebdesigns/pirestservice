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
            this.requestedData = "";
            this.requestedData.concat(response.data);
        });
    }

    function _driveBackwards() {
        $log.info('backwards function entered');
        return $http.get("/hits/backwards")
        .then(function(response) {
            $log.info('backwards hit');
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveRight() {
        $log.info('right function entered');
        return $http.get("/hits/right")
        .then(function(response) {
            $log.info('right hit');
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _driveLeft() {
        $log.info('left function entered');
        return $http.get("/hits/left")
        .then(function(response) {
            $log.info('left hit');
            this.requestedData = "";
            this.requestedData = response.data;
        });
    }

    function _rewind() {
        _driveLeft().then(_driveRight);
    }
}