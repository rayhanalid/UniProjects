class Employee :
    name = ""
    id = ""
    position = ""
    salary = 0
    def __init__(self,name,id,position,salary):
        self.name = name
        self.id = id
        self.position = position
        self.salary = salary
    def get_id(self)
        return self.id
    def get_name(self)
        return self.name
    def get_position(self)
        return self.position
    def get_salary(self)
        return self.salary
class Office:
    stafflist = []
    managerlist = []
    officerlist = []
    nostaff = 0
    def addstaffemployee(self, name, id, position, salary):
        self.stafflist.append(Employee(name, id, position, salary))
        self.nostaff += 1
    def addofficeremployee(self, name, id, position, salary):
        self.officerlist.append(Employee(name, id, position, salary))
        self.nostaff += 1
    def addmanageremployee(self, name, id, position, salary):
        self.managerlist.append(Employee(name, id, position, salary))
        self.nostaff += 1
    def deleteEmployee(self):
        bool = True
        id = input("Input ID[SXXXX]: ")
        for i in range(len(self.stafflist)):
            if self.stafflist[i].getid() == id:
                self.stafflist.pop(i)
                print("Data has been successfully deleted")
                bool = False
        for i in range(len(self.officerlist)):
            if self.officerlist[i].getid() == id:
                self.officerlist.pop(i)
                print("Data has been successfully deleted")
                bool = False

            if (bool == True):
                print("ID not found")

    def checkID(self, id):
        bool = True
        for i in range(len(self.stafflist)):
            if (id == self.stafflist[i].getid()):
                bool = False
        return bool

#sorry sir i cant complete it within the time limit