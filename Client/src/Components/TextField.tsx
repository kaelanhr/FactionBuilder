import { TextField as FluentTextField,  ITextFieldProps as IFluentTextFieldProps } from "@fluentui/react";

interface ITextFieldProps2<T> {
	model: T;
	modelProperty: string;
}

export const TextField = <T extends object>(props: ITextFieldProps2<T> & IFluentTextFieldProps) => {
	const handleUserInput = (event: any) => {
		props.model[props.modelProperty] = event.target.value;
	};

	return <FluentTextField onChange={handleUserInput} {...props} />;
};