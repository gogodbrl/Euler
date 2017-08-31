#coding:utf8
'''
Created on 2017. 8. 31.

@author: k170710
'''

class Problem36(object):
    def __init__(self):
        pass

    def __odd_check(self, number_str, number_length):
        # odd
        index = ( number_length / 2 )
        devine_front = number_str[:index]
        devine_behind = number_str[index+1:]
            
        return devine_front, devine_behind

        
    def __even_check(self, number_str, number_length):
        # even
        index = ( number_length / 2 ) - 1
        devine_front = number_str[:index+1]
        devine_behind = number_str[index+1:]
            
        return devine_front, devine_behind
        
    def is_symmetry(self, number):
        # -1 index 11 2/2 = 1, 1111 4/2 = 2 123321 = 6/2=3
        # middle index 8 1/2 = 0, 101 3/2 = 1, 10001 5/2 = 2  1000001 7/2 = 3
        number_str = str(number)  
        number_length = number_str.__len__()
        
        if number_length % 2 == 1 :
            devine_front, devine_behind = self.__odd_check(number_str, number_length)
        if number_length % 2 == 0 :
            devine_front, devine_behind = self.__even_check(number_str, number_length)
        
        reversed_behind_num = devine_behind[::-1]
        
        if devine_front == reversed_behind_num :
            return True
        
        return False
    
        
    def is_symmetry_binary(self, number):
        
        change_binary_str = str(bin(number))[2:]
        
        number_length = change_binary_str.__len__()
        
        if number_length % 2 == 1 :
            devine_front, devine_behind = self.__odd_check(change_binary_str, number_length)
        if number_length % 2 == 0 :
            devine_front, devine_behind = self.__even_check(change_binary_str, number_length)
        
        reversed_behind_num = devine_behind[::-1]

        if devine_front == reversed_behind_num :
            return True
        return False
    
    def run(self):
        NUMBER = 1000000
        
        sum = 0
        for i in range(1, NUMBER) :
            if self.is_symmetry(i) :
                if self.is_symmetry_binary(i) :
                    sum += i 
                    
        print sum
    
        
def main():
    Problem36().run()
    
if __name__ == '__main__':
    main()
    
        
        
