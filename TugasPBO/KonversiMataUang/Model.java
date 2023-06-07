package KonversiMataUang;

class Model {
    double USDtoRp(double a){
        return a * 14918.75;
    }

    double USDtoRiyal(double a){
        return a * 3.75;
    }

    double USDtoRinggit(double a){
        return a * 4.61;
    }

    double RptoUSD(double a){
        return a * 0.000067;
    }

    double RptoRiyal(double a){
        return a * 0.00025;
    }

    double RptoRinggit(double a){
        return a * 0.00031;
    }

    double RiyaltoUSD(double a){
        return a * 0.27;
    }

    double RiyaltoRp(double a){
        return a * 3978.67;
    }

    double RiyaltoRinggit(double a){
        return a * 1.23;
    }

    double RinggittoUSD(double a){
        return a * 0.22;
    }

    double RinggittoRp(double a){
        return a * 3234.71;
    }

    double RinggittoRiyal(double a){
        return a * 0.81;
    }
}
