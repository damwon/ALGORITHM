const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []

rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    input.shift()
    let nums = input.map(el=>Number(el))
    let diff = []
    for (let i=0; i<nums.length-1; i++) {
        diff.push(Math.abs(nums[i+1] - nums[i])) // nums배열을 정렬하고 차를 구하는것보다 정렬하지않고 절댓값을 반환하는것이 더 낫다고 판단
    }
    diff.sort((a,b) => a-b) //유클리드 호제법으로 최대공약수를 구하기위해 정렬
    let diffGcd = gcd(diff[1], diff[0])
    for (let i=1; i<diff.length-1; i++) {
        diffGcd = gcd(diff[i+1], diffGcd)
    }
    let factors = []
    for (let i=2; i<=diffGcd; i++) { // 약수중 1 은 제외하므로 2부터 시작
        if (diffGcd%i === 0) factors.push(i)
    }
    console.log(factors.join(" "))
})

function gcd(a, b) { // 조건: a>b (유클리드호제법)
    var R
    while ((a % b) > 0)  {
      R = a % b
      a = b
      b = R
    }
    return b
}
/* arr[1] = (arr[1]/M)*M + arr[1]%M
   arr[2] = (arr[2]/M)*M + arr[2]%M
   arr[2] - arr[1] = M * (arr[2]/M  -  arr[1]/M)  *arr[1]%M=arr[2]%M
   ...
   arr[N] - arr[N-1] = M * (arr[N] / M - arr[N-1] / M )
   => 각 수의 "차"에 대한 최대 공약수는 M
      M의 약수로 나누었을때도 나머지는 동일
      따라서 M의 약수들을 구하면 된다.
      
   gcd함수를 유클리드호제법으로 하지않으면 런타임 에러(StackSizeExceeded)가 떳다.
*/