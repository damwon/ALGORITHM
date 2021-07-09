const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []
rl.on("line", function(line){
    input = line.split(' ').map((el) => parseInt(el))
    rl.close()
}).on("close", function(){
    let A = input[0]
    let B = input[1]
    console.log(A+B)
    console.log(A-B)
    console.log(A*B)
    console.log(Math.floor(A/B)) //floor() - 주어진 수 이하의 가장 큰 정수 반환(내림)
    console.log(A%B)
})