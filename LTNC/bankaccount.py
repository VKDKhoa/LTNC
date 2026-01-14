class BankAccount:
    def __init__(self, initBalance: float = 0, password: str = "") -> None:
        self.balance: float = initBalance
        self.password: str = password
    
    def getBalance(self,pwd:str) -> float:
        if( pwd == self.password):
            return self.balance
        return -1.0
    
    def deposit(self, amount:float) -> None:
        self.balance += amount
    
    def withdraw(self, amount:float, pwd:str) -> None: 
        if( pwd == self.password and amount <= self.balance):
            self.balance -= amount