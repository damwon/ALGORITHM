const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []

rl.on("line", function(line){
    input = line.split(' ').map((el) => parseInt(el));
}).on("close", function(){
    const N = input.shift()
    const K = input.shift()
    let numerator = 1   //팩토리얼 연산을 위해 1로 초기화
    let denominator = 1
    for (let i=1; i<=N; i++) {
        numerator *= i
    }
    for (let i=1; i<=K; i++) {
        denominator *= i
    }
    for (let i=1; i<=N-K; i++) {
        denominator *= i
    }
    console.log(numerator/denominator)
})