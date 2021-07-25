const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []

rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let T = input.shift()
    let distance = input[0].split(" ").map((el)=>BigInt(el))
    let oil = input[1].split(" ").slice(0,-1).map((el)=>BigInt(el))
    let minOil = oil[0]
    let price = 0n //BigInt 연산시 초깃값 주의
    for (let i=0; i<(T-1); i++) {
        price += minOil*distance[i]
        if(oil[i+1] < minOil) minOil = oil[i+1]
    }
    console.log(String(price)) //BigInt 출력시 주의
})