# probleme-de-tomographie-discrete
Algo Projet

1.1:
//我们定义 T(j, ℓ)（j = 0, ..., M - 1, ℓ = 1, ..., k）为真，如果可以用子序列 (s1, ..., sℓ) 的前 ℓ 个块着色行 li 的前 j + 1 个格子 (i, 0), (i, 1), ..., (i, j)。
Q1:
    Si l’on a calcul´e tous les T(j, ℓ), comment savoir s’il est possible de colorier la ligne li enti`ere avec la s´equence enti`ere ?:
A1:
    检查 T(M-1, k) 的值来判断整行是否可以涂色，其中 M 是列数，k 是序列长度。如果 T(M-1, k) 为真，则意味着可以使用整个序列来涂色整行 li。
    On détermine si toute la ligne peut être colorée en vérifiant la valeur de T(M-1, k), où M est le nombre de colonnes et k est la longueur de la séquence. Si T(M-1, k) est vrai, cela signifie que toute la ligne li peut être colorée en utilisant la séquence entière.

Q2：
    Pour chacun des cas de base 1, 2a et 2b, indiquez si T(j, ℓ) prend la valeur vrai ou faux, ´eventuellement sous condition.
A2：
    1. Case ℓ = 0：
    当 ℓ = 0 时，没有黑色块需要放置。因此，T(j, ℓ) 在这种情况下总是真（true）。这是因为一个空序列总是可以被放置，无论 j 的值是多少。

    2. Case ℓ ≥ 1：
    a) j < sℓ - 1：(格子数量小于黑块数量)
    当 j 的值小于序列中第 ℓ 个块的长度减一时，这意味着当前格子数不足以容纳该黑色块。因此，在这种情况下，T(j, ℓ) 为假（false）。

    b) j = sℓ - 1：（(格子数量等于黑块数量)）
    当 j 等于序列中第 ℓ 个块的长度减一时，这意味着当前格子刚好能够容纳第 ℓ 个黑色块。但是，是否能放置这个黑色块还取决于之前的格子是否可以放置前 ℓ - 1 个黑色块。因此，在这种情况下，T(j, ℓ) 的值取决于 T(j - sℓ, ℓ - 1) 的值。


    这段话的法语翻译是：

    1. Cas ℓ = 0：
    Lorsque ℓ = 0, il n'y a aucun bloc noir à placer. Par conséquent, T(j, ℓ) est toujours vrai (true) dans ce cas. Cela est dû au fait qu'une séquence vide peut toujours être placée, quel que soit la valeur de j.

2   2. Cas ℓ ≥ 1：
    a) j < sℓ - 1 : 
    Lorsque la valeur de j est inférieure à la longueur du bloc ℓ dans la séquence moins un, cela signifie que le nombre actuel de cases est insuffisant pour accueillir ce bloc noir. Par conséquent, dans ce cas, T(j, ℓ) est faux (false).

    b) j = sℓ - 1 : 
    Lorsque j est égal à la longueur du bloc ℓ dans la séquence moins un, cela signifie que le nombre actuel de cases peut juste accueillir le bloc ℓ. Cependant, la possibilité de placer ce bloc noir dépend également de la capacité des cases précédentes à accueillir les ℓ - 1 premiers blocs noirs. Par conséquent, dans ce cas, la valeur de T(j, ℓ) dépend de T(j - sℓ, ℓ - 1).


Q3. 
    Exprimez une relation de r´ecurrence permettant de calculer T(j, ℓ) dans le cas 2c en fonction de deux valeurs T(j', l') avec j'< j, l' < l
A3.
    
