import React from 'react';
import { Form, Row, Col, Input, Button } from 'antd';
import { observer } from 'mobx-react';
import 'moment/locale/es'

@observer
class EntryComponent extends React.Component {

  constructor(props) {
    super(props);
    this.process = this.props.stores.productStore.process;
    this.productStore = this.props.stores.productStore;
  };

  getFields() {

    const { getFieldDecorator } = this.props.form;
    const children = [];

    children.push(
      <Col span={6} key={0}>
        <Form.Item label={'Producto'}>
          {getFieldDecorator('productId', {
            rules: [
              {
                required: false,
              },
            ],
          })(<Input />)}
        </Form.Item>
      </Col>,
    );

    children.push(
      <Col span={6} key={1}>
        <Form.Item label={'Cantidad'}>
          {getFieldDecorator('amount', {
            rules: [
              {
                required: false,
              },
            ],
          })(<Input />)}
        </Form.Item>
      </Col>,
    );

    children.push(
      <Col span={6} key={2}>
        <Form.Item label={'Valor Unitario'}>
          {getFieldDecorator('unitValue', {
            rules: [
              {
                required: false,
              },
            ],
          })(<Input />)}
        </Form.Item>
      </Col>,
    );

    
    children.push(
      <Col span={6} key={3}>
        <Form.Item label={'Valor Total'}>
          {getFieldDecorator('totalValue', {
            rules: [
              {
                required: false,
              },
            ],
          })(<Input />)}
        </Form.Item>
      </Col>,
    );

    return children;

  }

  handleSearch = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {

      console.log(values);

    });
  };

  render() {

    return (

      <Form 
        className="ant-advanced-search-form" 
        onSubmit={this.handleSearch}
        layout='vertical'
      >
        <Row gutter={24}>{this.getFields()}</Row>
        <Row>
          <Col span={24} style={{ textAlign: 'right' }}>
            <center>
              <Button type="primary" htmlType="submit">
                Registrar Entrada
              </Button>
            </center>
          </Col>
        </Row>
      </Form>

    );

  }
}

const WrappedSearchEntryComponent = Form.create({ name: 'advanced_search' })(EntryComponent);

export default WrappedSearchEntryComponent;