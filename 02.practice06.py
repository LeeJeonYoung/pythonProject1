def solution(s):
    if((len(s)==4) or (len(s)==6)):
        if((s.find("-")>=0) or (s.find(".")>=0)):
            if(s.isdigit()):
                return True
        else:
            if(s.isdigit()):
                return True
            else:
                return False
    else :
        return False
