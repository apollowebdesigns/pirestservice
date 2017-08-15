angular
    .module('app')
    .controller('OrdersController', OrdersController);

OrdersController.$inject = ['ordersService', 'orderDirectionService'];

function OrdersController(ordersService, orderDirectionService) {
    var vm = this;
    vm.requestedData = 'test data';
    vm.orderData = ordersService.orderData;
    vm.driveForwards = orderDirectionService.driveForwards;
    vm.driveBackwards = orderDirectionService.driveBackwards;
    vm.driveLeft = orderDirectionService.driveLeft;
    vm.driveRight = orderDirectionService.driveRight;
}

