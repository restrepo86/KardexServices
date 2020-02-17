import React from 'react';
import { observer } from 'mobx-react';
import Progress from '../../components/Progress';
import EntryComponent from '../../components/EntryComponent';
import ProductComponent from '../../components/ProductComponent';
import OutputComponent from '../../components/OutputComponent';

@observer
class InventarioTodoUnoContainer extends React.Component {

    render() {
        return (
          
            <div>
                <Progress  { ...this.props.stores.productStore.process.getData() } />
                <ProductComponent { ...this.props}/>
                <br />
                <EntryComponent { ...this.props}/>
                <br />
                <OutputComponent { ...this.props}/>
            </div>
          
        );
      }

}

export default InventarioTodoUnoContainer;