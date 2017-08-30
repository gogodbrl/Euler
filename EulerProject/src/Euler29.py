'''
Created on 2017. 8. 30.

@author: junga
'''


class Problem29(object):
    def __init__(self):
        pass
    
    def get_number(self, minValue, maxValue):
        
        number_list = []
        for num in range(minValue, maxValue+1) :
            number_list.append(num)
        return number_list
    
    def calc(self, list_one, list_two):
        elem_list = []
        for one_elem in list_one :
            for two_elem in list_two :
                result = pow(one_elem, two_elem) 
                elem_list.append(result)
        return elem_list
    
    def get_uniq_count(self, merge_list):
        return len(set(merge_list))
    
    def run(self) :
        list_a = self.get_number(2, 100)
        list_b = self.get_number(2, 100)
        
        list_pow_one = self.calc(list_a, list_b)
        list_pow_two = self.calc(list_b, list_a)
        
        merge_list = list_pow_one + list_pow_two
        
        print self.get_uniq_count(merge_list)

def main() :
    p29 = Problem29()
    p29.run()        

if __name__ == '__main__' :
    main()
