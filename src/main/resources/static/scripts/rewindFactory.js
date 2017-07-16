angular
    .module('app')
    .factory('rewindFactory', rewindFactory);

driveService.$inject = ['$log'];

/**
 * Model for rewinding Raspberry Pi
 * @param $log
 */
function rewindFactory ($log) {
    var rewindRequests = [];

    var rewindFactoryObj = {
        rewindRequests: rewindRequests
    };

    return rewindFactoryObj;
}