SQUARE_NUMBER = 5
MAX_NUM = 1000000
        
class Problem30(object):
    def __init__(self):
        pass
        
    def split_number(self, number):    
        splited_num_list = []
        number_str = str(number)
        for str_num in number_str :
            splited_num_list.append(str_num)
        return splited_num_list
            
    def algorithm_calc(self):
        total_result = 0
        for num in range(1, MAX_NUM+1):
            elem_sum = 0
            splited_num_list = self.split_number(num)
            
            for idx in range(0, len(splited_num_list)) :
                elem_num = int(splited_num_list[idx])
                elem_sum += pow(elem_num, SQUARE_NUMBER)
            
            if num == elem_sum :
                total_result += num
                print num 
        return total_result -1
        
    def run(self):
        print self.algorithm_calc()
    
def main():
    p30 = Problem30()
    p30.run()

if __name__ == '__main__':
    main()
