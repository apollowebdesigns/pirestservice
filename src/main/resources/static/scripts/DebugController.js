angular
    .module('app')
    .controller('DebugController', DebugController);

DebugController.$inject = ['rewindFactory'];

function DebugController(rewindFactory) {
    var vm = this;
    vm.rewindRequests = rewindFactory.rewindRequests;
}
