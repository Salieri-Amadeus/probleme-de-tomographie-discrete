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

    b) j = sℓ - 1：
    当 j 等于序列中第 ℓ 个块的长度减一时，这意味着当前格子刚好能够容纳第 ℓ 个黑色块。所以如果l = 1时，为真，否则为假。

    1. Cas ℓ = 0：
    Lorsque ℓ = 0, il n'y a aucun bloc noir à placer. Par conséquent, T(j, ℓ) est toujours vrai (true) dans ce cas. Cela est dû au fait qu'une séquence vide peut toujours être placée, quel que soit la valeur de j.

    2. Cas ℓ ≥ 1：
    a) j < sℓ - 1 : 
    Lorsque la valeur de j est inférieure à la longueur du bloc ℓ dans la séquence moins un, cela signifie que le nombre actuel de cases est insuffisant pour accueillir ce bloc noir. Par conséquent, dans ce cas, T(j, ℓ) est faux (false).

    b) j = sℓ - 1 : 
    Lorsque j est égal à la longueur du bloc ℓ dans la séquence moins un, cela signifie que le nombre actuel de cases peut juste accueillir le bloc ℓ. Donc si l = 1, alors T(j, 1) est vrai. Sinon faux.


Q3. 
    Exprimez une relation de r´ecurrence permettant de calculer T(j, ℓ) dans le cas 2c en fonction de deux valeurs T(j', l') avec j'< j, l' < l
A3.
    T(j, ℓ) = T(j - 1, ℓ) || T(j-sℓ-1, ℓ - 1)
    因为如果格子比当前少（j - 1）, 都能填上前l个色块，那么当前的格子数一定也能填上。 或者如果格子比当前少sl-1个时能填上l - 1的色块，那么当前格子一定能填上。

    Car si on peut placer les ℓ premiers blocs noirs dans un cas où il y a une case en moins (j - 1), alors on peut certainement les placer avec le nombre actuel de cases. Ou, si on peut placer les ℓ - 1 premiers blocs noirs avec j - sℓ - 1 cases, alors on peut aussi les placer dans le cas actuel.

Q4.
    Voir Util.java


1.2
Q5.
    Modifiez chacun des cas de l’algorithme pr´ec´edent afin qu’il prenne en compte les cases d´ej`a colori´ees.
A5.
    l = 0:
        传入的有色行中不能有黑色块，否则为false。
    l >= 1 && j < sℓ - 1:
        false
    l >= 1 && j = sℓ - 1:
        l == 1 && 传入的有色行中不能有白色块
    l >= 1 && j > sℓ - 1:
        最后一块为白/空：T(j - 1, ℓ)
        最后一块为黑：
            T(j-sℓ-1, ℓ - 1) && j - sℓ 个格子到第 j 个格子都是黑且j-sl-1为白： T(j-sℓ-1, ℓ - 1)
            否则：false

