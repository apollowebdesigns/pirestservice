angular
    .module('app')
    .controller('AppController', AppController);

AppController.$inject = ['ledService', 'driveService', 'exitService'];

function AppController(ledService, driveService, exitService) {
    var vm = this;
    vm.requestedData = 'test data';
    vm.getData = ledService.getData;
    vm.driveForwards = driveService.driveForwards;
    vm.driveBackwards = driveService.driveBackwards;
    vm.driveRight = driveService.driveRight;
    vm.driveLeft = driveService.driveLeft;
    vm.driveData = driveService.driveData;
    vm.driveData = driveService.driveData;
    vm.requestedData = driveService.requestedData;
    vm.killPi = exitService.killPi;
    vm.rewind = driveService.rewind;
}
