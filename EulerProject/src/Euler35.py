
MY_RETURN = 1000000

class Problem35(object):
    
    
    def __init__(self):
        pass
 
    def circular_number(self, number):
        #input : prime number 13
        # output : circular_number_list ( [int, int, ... ])
        
        number_str = str(number)
        number_str_length = number_str.__len__()
        
        circular_number_list = []
        
        if number_str_length == 1 :
            circular_number_list.append(number)
            circular_number_list.append(None)
            return circular_number_list
            
        for shift_index in range( 1, number_str_length ) :
            circular_str = ''
            for now_index in range(shift_index, shift_index + number_str_length ) : 
                
                if len(circular_str) == number_str_length :
                    break
                 
                shift_index = now_index % number_str_length
                
                circular_str += number_str[shift_index]
                
            circular_number_list.append(int(circular_str))
        circular_number_list.append(None)
        return circular_number_list
    
    def is_prime_number(self, number):
        #input : 20 ( 1 to number ) 
        
        increase_num = 2
        
        while (increase_num < number) :
            if number % increase_num == 0 :
                break
            else :
                increase_num +=1
                
        if increase_num == number :
            return True
        return False
    
    def calc(self):
        global MY_RETURN
        count = 0 
        for i in range(MY_RETURN) :
            if self.is_prime_number(i) :
                circular_list = self.circular_number(i)
                
                for circular_prime_number in circular_list :
                    
                    if circular_prime_number == None :
                        count +=1 
                        break
                    
                    if not self.is_prime_number(circular_prime_number) :
                        break
                    
                    
        print 'total count : ', count  
def main() :
    Problem35().calc()

if __name__ == '__main__':
    main()
