angular
    .module('app')
    .factory('rewindFactory', rewindFactory);

driveService.$inject = ['$log'];

/**
 * Model for rewinding Raspberry Pi
 * @param $log
 */
function driveService ($log) {
    var rewindRequests = [];

    var rewindFactory = {
        rewindRequests: rewindRequests
    };

    return rewindFactory;
}