angular
    .module('app')
    .factory('rewindFactory', rewindFactory);

driveService.$inject = [];

/**
 * Model for rewinding Raspberry Pi
 * @param $log
 */
function rewindFactory () {
    var rewindRequests = [];

    var rewindFactoryObj = {
        rewindRequests: rewindRequests
    };

    return rewindFactoryObj;
}