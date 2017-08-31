'''
Created on 2017. 8. 31.

@author: k170710
'''
MAX_LINE = 1000

class Problem39(object):
    def __init__(self):
        pass
    
    def is_pitagoras(self, a, b, c):
        if (a*a + b*b) ==  c*c :
            return True
        return False
    
    def calc(self):
        
        line = 0
        p = 0
        count_dict = {}
        while (p <= MAX_LINE ) :
            
            line = line+1
            p_make_count = 0
            
            for a in range(1, line) :
                for b in range(a+1, line) :
                    for c in range(b+1, line) :
                        
                        if self.is_pitagoras(a, b, c) :
                            p_make_count+=1
                            p = a+b+c
                            
                            if count_dict.has_key(str(p)) :
                                count_dict[str(p)].append((a,b,c))
                            else :
                                count_dict[str(p)] = [(a,b,c)]
        
        max_val = 0                        
        for k,v in count_dict.items() :
            if max_val < len(set(v)) :
                max_val = len(set(v)) 
                print k, len(set(v)), set(v)
def main():
    Problem39().calc()
    
if __name__ == '__main__':
    main()
