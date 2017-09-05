'''
Created on 2017. 9. 4.

@author: junga
'''

from decimal import *

MAX_NUM = 1000
MAX_DECIMAL = 10000

getcontext().prec = MAX_DECIMAL

def circular_number_check(my_list):
    ret_str = ''.join(my_list)
    
    for idx in range(0, len(my_list)) :
        
        if ret_str[0] == my_list[idx] :
            
            pattern = ret_str[:idx]
            pattern_len = len(pattern)
            
            if pattern_len <= 1 : continue
            
            if ret_str[pattern_len : pattern_len*2] == pattern :
                return pattern_len
                
my_value = 0
my_i = 0

for i in range(2, MAX_NUM) :
    
    value =  Decimal(1)/Decimal(i)
    
    value_str = str(value).split(".")[-1]
    
    #0.33333333333, 0.6666666666
    if len(set(value_str)) == 1 :
        continue
    
    #0.125, 0.25
    if len(value_str) < 5 :
        continue
    
    my_list = []
    for j in value_str :
        my_list.append(j)
    
    max_value = circular_number_check(my_list)
    
    if max_value > my_value :
        my_value = max_value
        my_i = i
        
print my_value, my_i
