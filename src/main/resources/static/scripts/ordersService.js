angular
    .module('app')
    .service('ordersService', ordersService);

ordersService.$inject = ['$http', '$log'];

/**
 * Service controls Raspberry Pi Preset Orders
 * @param $http
 * @param $log
 */
function ordersService ($http, $log) {
    this.orderData = _orderData;

    this.requestedData = "";

    function _orderData() {
        $log.info('driving function entered function entered');
        return $http.get("/hits/execute")
            .then(function(response) {
                $log.info('orders carried out');
                this.requestedData = "";
                this.requestedData.concat(response.data);
            });
    }
}