const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
const strToNum = (str) =>
    str.split(' ').map((numStr) => Number(numStr))

let input = []

rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    input.shift()
    let factors = input.map((str)=>strToNum(str))[0]  //number type으로 배열 생성
    factors.sort((a,b) => a - b)                      //오른차순으로 정렬
    console.log(factors.slice(0,1)*factors.slice(-1)) //진짜 약수 중 가장 작은 수와 가장 큰 수 곱해서 N 출력
})
//진짜 약수가 1개인 경우에도 (ex 9: 3) 배열요소중 가장 작은것과 큰것을 곱하면(동일하기때문에) N을 구할수있음