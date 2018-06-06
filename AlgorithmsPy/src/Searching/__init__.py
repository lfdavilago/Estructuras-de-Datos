
def BinarySearch(Array, n, Dw, Up):
    MidPoint = (int)((Dw + Up) / 2)
    if Dw == Up :
        if n == Array[MidPoint]:
            return MidPoint;
        else:
            return False
    else:
        if n > Array[MidPoint]:
            return BinarySearch(Array, n, MidPoint + 1, Up)
        elif n < Array[MidPoint]:
            return BinarySearch(Array, n, Dw, MidPoint - 1)
        elif n == Array[MidPoint]:
            return MidPoint;

def _BinarySearch_(Array, n):
    Dw = 0
    Up = len(Array)

    while Dw <= Up :
        MidPoint = (int) ((Dw + Up) / 2)
        if Array[MidPoint] == n :
            return MidPoint
        if Array[MidPoint] < n:
            Dw = MidPoint + 1
        else:
            Up = MidPoint - 1
                
def InterpolationSearch(Array, n):
    Dw = 0
    Up = len(Array) - 1
    
    while Dw <= Up :
        MidPoint = (int) (Dw + (((Up - Dw) / (Array[Up] - Array[Dw]) )*( n - Array[Dw])))
        if Array[MidPoint] == n :
            return MidPoint
        if Array[MidPoint] < n:
            Dw = MidPoint + 1
        else:
            Up = MidPoint - 1
            
def LinearSearch(Array, n):
    for i in range(len(Array)):
        if Array[i] == n :
            return i
    return -1

Array = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
n = 9
print("Recursiva " + str(BinarySearch(Array, n, 0, len(Array))))
print("\nSin recursion " + str(_BinarySearch_(Array, n)))
print("\nInterpolacion " + str( InterpolationSearch(Array, n)))


