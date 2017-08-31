'''
Created on 2017. 8. 31.

@author: k170710
'''

MAX_NUM = 100000

class Problem34(object):
    def __init__(self):
        pass
    
    def factorial(self, max_number):
        #input : 4
        #output : 24
        fax_num = 1
        for i in range(max_number, 1, -1) :
            fax_num = fax_num * i
        return fax_num 
    
    def split_number(self, number):
        #input : 23
        #output : [2,3]
        my_list = []
        number_str = str(number)
        for elem in number_str :
            my_list.append(int(elem)) 
        return my_list
    
    def calc(self):
        for i in range(1, MAX_NUM) :
            
            if (i ==1 or i == 2) :
                continue
                
            calc_list = self.split_number(i)
            total_sum = 0
            for elem in calc_list :
                total_sum += self.factorial(elem)
            
            if total_sum == i :
                print i
            
def main():
    Problem34().calc()

if __name__ == '__main__':
    main()
