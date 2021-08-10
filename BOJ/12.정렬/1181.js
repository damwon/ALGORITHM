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
    let nums = []
    input.forEach((element) => {
        if (!nums.includes(element)) {
            nums.push(element);
        }
    })
    nums.sort((a, b) => a.localeCompare(b))
    .sort((a, b) => a.length - b.length)
    console.log(nums.join('\n'))
})