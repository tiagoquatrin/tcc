/*
 * Extens�o JQuery para campos do tipo INTEIRO. Pode ser aplicada sobre um campo do tipo:
 * 
 * <input type="text" id="meuCampo"/>
 * 
 * da seguinte forma:
 * 
 * $("#meuCampo").setIntField()
 */

(function($){
	
	$.extend({
		
		int_maskerade : {
			
			BKSPACE : 8,
			DELETE : 46,
			
//			/field : null,
			
			set: function(el, options){
				field = this;

				return $(el).each(function(){
					var $this = $(this);					
					$this.css('text-align','right');
					$this.bind('keyup', {thisObj: field}, field._keyUp);
					$this.bind('keypress', {thisObj: field}, field._keyPress);
					$this.bind('mouseup', {thisObj: field}, field._mouseUp);
					$this.bind('focus', {thisObj: field}, field._focus);
				});
			},
			
			_keyUp : function(e) {
				var thisObj = e.data.thisObj;
				var	value = $(e.target).val();
				thisObj.__formatValue(e.target, value);
				return true;
			},
			
			_keyPress : function(e){
				var thisObj = e.data.thisObj;
				
				if (e.ctrlKey || e.metaKey || e.altKey) 
					return true;
				
				var keyNumber = thisObj._getKeyNumber(e);
				var	c = String.fromCharCode(keyNumber);
				
				if (c >= '0' && c <= '9')
				{
					var	value = $(e.target).val();
					var caret = thisObj._getRangePosition(e.target);
					var	valueStart = value.substring(0, caret.start);
					var	valueEnd = value.substring(caret.end, value.length);
					value = valueStart + c + valueEnd;
					thisObj.__formatValue(e.target, value);
				}				
				else if (c == '-')
				{
					var	value = $(e.target).val();

					if (value.length > 0)
					{
						value = (value[0] == '-') ? value.substring(1) : '-' + value;
						thisObj.__formatValue(e.target, value);
					}
				}
				else if (keyNumber == 8)
				{
					var	value = $(e.target).val();
					
					if (value.length > 0)
						value = value.substring(0, value.length-1);
					
					thisObj.__formatValue(e.target, value);
				}
						
				return false;
			},
			
			_mouseUp : function(e) {
				var thisObj = e.data.thisObj;
				var len = $(e.target).val().length;
				thisObj.__setRangePosition(e.target, len, len);
				return true;
			},
			
			_focus : function(e) {
				var thisObj = e.data.thisObj;
				var len = $(e.target).val().length;
				thisObj.__setRangePosition(e.target, len, len);
				return true;
			},
			
			__formatValue : function(target, value) {
				value = this.__removeInvalidChars(value);
				value = this.__applyMask(value);
				value = value.substring(value.length-15);
				$(target).val(value);
				return true;
			},
				
			__removeInvalidChars : function(value){
				var sign = '';
				
				if (value[0] == '-')
				{
					value = value.substring(1);
					sign = '-';
				}
				
				for (var i = value.length-1; i >= 0; i--)
					if (value[i] < '0' || value[i] > '9')
						value = value.substring(0, i) + value.substring(i+1);
				
				while (value.length > 1 && value[0] == '0')
					value = value.substring(1);
				
				return sign + value;
			},
			
			__applyMask : function(value){
				var len = value.length;
				
				if (len == 0)
					return value;
				
				var sign = (value[0] == '-') ? -1 : 1;
				
				if (sign == -1)
				{
					value = value.substring(1);
					len--;
				}

				if (len > 3)
					value = value.substring(0, len - 3) + '.' + value.substring(len - 3); 

				if (len > 6)
					value = value.substring(0, len - 6) + '.' + value.substring(len - 6); 

				if (len > 9)
					value = value.substring(0, len - 9) + '.' + value.substring(len - 9); 

				if (sign == -1)
					value = '-' + value;

				return value;
			},
			
			_getKeyNumber : function(e){
				return (e.charCode || e.keyCode || e.which);
			},
			
			_getRangePosition : function(input){
				var result = { start: 0, end: 0 };
				if (input.setSelectionRange){
					result.start = input.selectionStart;
					result.end = input.selectionEnd;
				}
				else if (document.selection && document.selection.createRange){
					var range = document.selection.createRange();
					var r2 = range.duplicate();
					result.start = 0 - r2.moveStart('character', -100000);
					result.end = result.start + range.text.length;
				}
				return result;
			},

			__setRangePosition : function(input, selectionStart, selectionEnd) {
				if (input.setSelectionRange) {
					input.focus();
					input.setSelectionRange(selectionStart, selectionEnd);
				}
				else if (input.createTextRange) {
					var range = input.createTextRange();
					range.collapse(true);
					range.moveEnd('character', selectionEnd);
					range.moveStart('character', selectionStart);
					range.select();
				}
			}
		}
	});
	
	$.fn.setIntField = function(options) {
		return $.int_maskerade.set(this, options);
	};
	
})(jQuery);