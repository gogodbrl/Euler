'''
Created on 2017. 8. 31.

@author: k170710
'''
INTEGER = 1000000

class Problem40(object):
    def __init__(self) :
        pass
    
    
    def get_String(self):
        unlimited_str = ''
        for i in range(0, INTEGER) :
            unlimited_str += str(i)
        return unlimited_str 
    
    def calc(self):
        my_str = self.get_String()
        
        d1 = int(my_str[1])
        d10 = int(my_str[10])
        d100 = int(my_str[100])
        d1000 = int(my_str[1000])
        d10000 = int(my_str[10000])
        d100000 = int(my_str[100000])
        d1000000 = int(my_str[1000000])
        
                        
        print d1*d10*d100*d1000*d10000*d100000*d1000000 #210
        print d1,d10,d100,d1000,d10000,d100000,d1000000 #1 1 5 3 7 2 1
            
            

def main():
    p40 = Problem40()
    p40.calc()
    
    
    
if __name__ == '__main__':
    main()
