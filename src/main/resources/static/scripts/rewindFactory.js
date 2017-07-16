angular
    .module('app')
    .factory('rewindFactory', rewindFactory);

rewindFactory.$inject = ['$log'];

/**
 * Model for rewinding Raspberry Pi
 * @param $log
 */
function rewindFactory ($log) {
    $log.debug("inside rewind factory");
    var rewindRequests = [];

    var rewindFactoryObj = {
        rewindRequests: rewindRequests
    };

    return rewindFactoryObj;
}