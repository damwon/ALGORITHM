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
    let T = parseInt(input.shift())
    let timeTable = input
        .map((str)=>strToNum(str))
        .sort((a,b) => a[1] -b[1] || a[0] - b[0])

    let cnt = 0
    let tempEnd = 0

    timeTable.forEach(([start, end]) => {
        if ( start < tempEnd) {
            return
        }
        cnt++
        tempEnd = end
    })

    console.log(cnt)
})