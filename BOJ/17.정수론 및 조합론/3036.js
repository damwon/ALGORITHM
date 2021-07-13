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
    let radiusTable = input.map((str)=>strToNum(str))[0]
    const firstRadius = radiusTable.shift()
    for (let i of radiusTable) {
        let factor = gcd(firstRadius, i)
        console.log(firstRadius/factor + "/" + i/factor)        
    }
})
// 기약분수로 만들기위해 첫번째 링의 반지름과 비교하는 링의 반지름의 최대공약수로 각 각 나눠준다
const gcd = (A, B) => {
    if (B === 0) {
        return A;
    } else {
        return gcd(B, A % B);
    }
}