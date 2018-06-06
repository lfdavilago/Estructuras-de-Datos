
def InsertSort(Array):
    for i in range(1,len(Array)):
        temp = Array[i]
        Index = i
        while Index > 0 and Array[Index - 1] > temp : 
            Array[Index] = Array[Index - 1]
            Index = Index - 1
        Array[Index] = temp

def QuickSort(Array):
    if len(Array) <= 1 :
        return Array
    else:
        Pivot = Array[0]
        less_A = []
        Upper_A = [] 
        for i in range(1,len(Array)):
            if Array[i] < Pivot :
                less_A.append((Array[i]))
            else:
                Upper_A.append(Array[i])
        less_A = QuickSort(less_A)
        less_A.append(Pivot)
        Upper_A = QuickSort(Upper_A)     
        return less_A + Upper_A
    
print("Prueba  InsertSort")
arreglo = input().split(",")
for i in range(len(arreglo)):
    arreglo[i] = int(arreglo[i])
    
arreglo = QuickSort(arreglo)
print(arreglo)