angular
    .module('app')
    .controller('AppController', AppController);

AppController.$inject = ['ledService', 'driveService'];

function AppController(ledService, driveService) {
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
}
