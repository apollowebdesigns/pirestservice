angular
    .module('app')
    .controller('MapController', MapController);

MapController.$inject = ['$scope', '$log'];

function MapController ($scope, $log) {

    angular.extend($scope, {
                southwest: {
                    lat: 51.505,
                    lng: -0.09,
                    zoom: 8
                },

                markers: {

                    theflat: {
                        group: 'southwest',
                        lat: 50.713270099999995,
                        lng: -3.5368812999999997,
                        label: {
                            message: "The Flat",
                            options: {
                                noHide: true
                            }
                        }
                    },

                    beechfield: {
                        group: 'southwest',
                        lat: 51.545,
                        lng: -0.070,
                        label: {
                            message: "Beechfield",
                            options: {
                                noHide: true
                            }
                        }
                    },

                    annashouse: {
                        group: 'southwest',
                        lat: 51.4644,
                        lng:-0.1924,
                        label: {
                            message: "Annas House",
                            options: {
                                noHide: true
                            }
                        }
                    },

                    work: {
                        group: 'southwest',
                        lat: 51.4638,
                        lng: -0.1677,
                        label: {
                            message: "Work",
                            options: {
                                noHide: true
                            }
                        }
                    }
                },
            });
}
