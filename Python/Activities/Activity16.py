class Cars :
    def __init__(self,manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")
    
    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")

#create objects
car1 = Cars("BMW" , "cdl" ,"2001" ,"Automatic", "Blue")
car2 = Cars("VW" , "POLO" ,"2010" ,"Manual", "Grey")
car3 = Cars("TATA" , "Nexon" ,"2020" ,"Manual" ,"WHite")

car2.accelerate()
car2.stop()


