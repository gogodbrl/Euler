'''
Created on 2017. 8. 30.

@author: junga
'''

MAX_METRIC = 1001

class Problem28(object):
    def __init__(self):
        pass
    
    def algorithm_calc(self):
        #1X1 - 1  
        #3X3 - 9  ( 3, 5, 7, 9 ) 2 / 2 /2
        #5*5 - 25 ( 13, 17, 21, 25 ) 4 / 4 / 4
        #7*7 - 49 ( 31, 37, 43, 49 ) 6/ 6/ 6
        result = 0  
        
        for metric in range(3, MAX_METRIC+1, 2) :
            max_size = metric * metric
            interval = metric - 1
            
            for diagonal_num in range(4) :
                result += max_size
                max_size = max_size - interval
                
        print result + 1 
            
            
    
    def run(self):
        self.algorithm_calc()
    

def main() :
    p28 = Problem28()
    p28.run()        

if __name__ == '__main__' :
    main()
    
        
