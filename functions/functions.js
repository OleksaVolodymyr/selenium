function forEach(arr,fn){
   for(var i=0;i<arr.length;i++){
      fn(arr[i]);
   }
}
function increment(num){ 
  return  num+1;
}
function getTransformedArray(arr,fn){
  var array =[];
  forEach(arr,function(el){
    array.push(fn(el));
  });
  return array;
   
}
function pluckByAttribute(arr,label){
  return getTransformedArray(arr, function(el){
     return el[label];
  });
}

function cypherPhrase (obj, string){
  return getTransformedArray(string.split(""), function(el){
    return obj[el]||el;
  }).join('');
}
function decypherPhrase (obj,string){
 
  var invert = function (obj) {
  var new_obj = {};
  for (var prop in obj) {
    if(obj.hasOwnProperty(prop)) {
      new_obj[obj[prop]] = prop;
    }
  }
  return new_obj;
  }
  return cypherPhrase (invert(obj), string);
}
function getTopNRichestNames (count, arr){
  arr = arr.map(function(x){
     var abbreviation ={B:1e9, M:1e6, K:1e3};    
     return {name: x.name, income:(x.income).charAt(0)*abbreviation[(x.income).charAt(1)]};
  });
  arr = arr.sort(function(a,b){
    return b.income - a.income;
  });
  var top = [];
  for(var i=0;i<count;i++){
    if(arr[i]){
      top.push(arr[i].name);
    }
  }
  return top;
}